package com.nayan.code.assessments.may_2020;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionStreams {


    public static void main(String[] args) {
        //BigDecimal
    }

    public Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, Stream<Stream<ProcessedTransaction>> processed) {
        if(Objects.isNull(pending))
            return Stream.empty();
        else if(Objects.isNull(processed))
            return pending;

        Set<Long> ids = processed.flatMap(processedTransactionStream -> processedTransactionStream)
                .filter(processedTransaction -> (Objects.nonNull(processedTransaction.getId()) || processedTransaction.getId().equalsIgnoreCase("")))
                .filter(processedTransaction -> Objects.nonNull(processedTransaction.getStatus()))
                .filter(processedTransaction -> (processedTransaction.getStatus().isPresent() && "DONE".equalsIgnoreCase(processedTransaction.getStatus().get())))
                .map(processedTransaction -> Long.parseLong(processedTransaction.getId())).collect(Collectors.toSet());

        return pending.filter(pendingTransaction -> ids.contains(pendingTransaction.getId()));
    }

    private class PendingTransaction {
        private Long id; // always set correctly

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    private class ProcessedTransaction {
        private String id;
        private Optional<String> status;

        public Optional<String> getStatus() {
            return status;
        }

        public void setStatus(Optional<String> status) {
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
